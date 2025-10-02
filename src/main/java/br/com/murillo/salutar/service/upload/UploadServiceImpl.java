package br.com.murillo.salutar.service.upload;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Component
public class UploadServiceImpl implements IUploadService {


    @Override
    public String uploadFile(MultipartFile arquivo) {
        try {
            System.out.println("DEBUG - Realizando upload do arquivo: "  + arquivo.getOriginalFilename());
            String pastaDestino = "C:\\Users\\liloo\\OneDrive\\Documentos\\Materiais e Exercicios IsiFlix\\Projetos\\Salutar\\Angular_projects\\salutar-front\\src\\assets\\media";
            String extension = arquivo.getOriginalFilename().substring(arquivo.getOriginalFilename().lastIndexOf("."));
            String newFileName = UUID.randomUUID().toString() + extension;
            Path path = Paths.get(pastaDestino+ File.separator + newFileName);
            Files.copy(arquivo.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            return newFileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
