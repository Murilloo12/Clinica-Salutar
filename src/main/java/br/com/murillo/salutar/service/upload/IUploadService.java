package br.com.murillo.salutar.service.upload;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadService {
    public String uploadFile(MultipartFile arquivo);
}
