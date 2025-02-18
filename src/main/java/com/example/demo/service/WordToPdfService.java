package com.example.demo.service;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class WordToPdfService {
	
	 public byte[] convertDocxToPdf(MultipartFile file) throws IOException {
	        // Cargar el documento de Word
	        Document document = new Document();
	        document.loadFromStream(file.getInputStream(), FileFormat.Docx);
	        // Convertir a PDF y guardarlo en un ByteArrayOutputStream
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        document.saveToStream(outputStream, FileFormat.PDF);
	        document.close();

	        return outputStream.toByteArray();
	    }

}
