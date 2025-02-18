package com.example.demo.controller;

import com.aspose.words.Document;
import com.example.demo.service.WordToPdfService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayOutputStream;
import java.io.File;

@Controller
@RequestMapping(value = "/convert")
@CrossOrigin(origins = {"*"})
public class WordToPdfController {
	
	@PostMapping("/aspose-word-to-pdf")
    public ResponseEntity<byte[]> convertWordToPdfAspose(@RequestParam("file") MultipartFile file) {
        try {
            // Convertir Word a PDF
            Document doc = new Document(file.getInputStream());
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            doc.save(outputStream, com.aspose.words.SaveFormat.PDF);

            // Preparar la respuesta con el PDF generado
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=converted.pdf");

            return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
	
	private final WordToPdfService wordToPdfService;
    
	public WordToPdfController(WordToPdfService wordToPdfService) {
        this.wordToPdfService = wordToPdfService;
    }
    
	@PostMapping("/spire-word-to-pdf")
    public ResponseEntity<byte[]> convertWordToPdfSpire(@RequestParam("file") MultipartFile file) {
        try {
            byte[] pdfBytes = wordToPdfService.convertDocxToPdf(file);

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=converted.pdf")
                    .body(pdfBytes);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
