package com.ecrseer.scraptiss.services;

import com.ecrseer.scraptiss.entities.webscrap.TabelaQuadro;
import com.ecrseer.scraptiss.repositories.WebScrapingService;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;


@Service
@Slf4j
public class WebScrapingServiceImpl implements WebScrapingService {


	@Override
	public TabelaQuadro getQuadro(int numeroQuadro) {
		String url="https://www.gov.br/ans/pt-br/assuntos/prestadores/padrao-para-troca-de-informacao-de-saude-suplementar-2013-tiss/padrao-tiss-2013-novembro-2021";
		Document webPage = null;
		try {
			webPage = Jsoup.connect(url).get();
			Element colunaTabelaDesejada = webPage.select("td:contains(Componente Organizacional)").first();

			Element btnBaixaPdf = colunaTabelaDesejada.parent().select("a").first();
			String linkDoPdf = btnBaixaPdf.attr("href");

			return tabelaDoPDF(linkDoPdf,"Quadro "+numeroQuadro);
		} catch (IOException e) {
			e.printStackTrace();
		}


		return null;
	}
	private void salvaPDFeCsv(PDDocument pdf,TabelaQuadro tq,String nomeQuadro){
		String caminhoArquivo = System.getProperty("user.dir");

		try (PrintWriter writer = new PrintWriter(
				caminhoArquivo+File.separator+nomeQuadro+".csv")){
			StringBuffer buffer = new StringBuffer();
			String camposEmCsv= tq.getEntidades().get(0).nomeCamposEmCsv();
			buffer.append(camposEmCsv);
			tq.getEntidades().forEach(entidade->{
				buffer.append(entidade.emCsv());
			});

			writer.write(buffer.toString());
			pdf.save(caminhoArquivo+"/componente.pdf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private TabelaQuadro tabelaDoPDF(String linkDoPdf,
									 String nomeQuadro) {
		URL url = null;
		try {
			url = new URL(linkDoPdf);
		} catch (MalformedURLException e) {
			return null;
		}
		try (InputStream in = url.openStream()) {

			PDDocument pdf = PDDocument.load(in);
			if(!pdf.isEncrypted()){
				PDFTextStripper stripper = new PDFTextStripper();
				String text = stripper.getText(pdf);
				int inicio = text.indexOf(nomeQuadro);
				text = text.substring(inicio);
				int fim = text.indexOf("Fonte");

				if(fim!=-1){
					String tabela = text.substring(0,fim);
					TabelaQuadro tq = new TabelaQuadro(tabela);
					salvaPDFeCsv(pdf,tq,nomeQuadro);

					return tq;
				}

			}
		} catch (IOException e) {
			return null;
		}
		return null;
	}



}
