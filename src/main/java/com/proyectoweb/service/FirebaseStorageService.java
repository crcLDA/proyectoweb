package com.proyectoweb.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FirebaseStorageService {
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "proyectoweb-cdbbb.appspot.com";

    //Esta es la ruta básica de este proyecto Techshop carpeta "raiz" del proyecto
    final String rutaSuperiorStorage = "proyectoweb";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "Firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "proyectoweb-cdbbb-firebase-adminsdk-gmt5z-4712c2636e.json";
}
