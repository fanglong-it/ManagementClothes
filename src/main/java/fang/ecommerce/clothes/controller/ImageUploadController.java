package fang.ecommerce.clothes.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/get_image")
public class ImageUploadController {

    @GetMapping("show/{photo}")
    @ResponseBody
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable(name = "photo") String photo) {
        if (photo != null) {
            try {
                photo = "Fanglong.png";

                Path filename = Paths.get("\"D:\\Source Code\\Intellij Programing\\JAVA_WEB\\ClothesManagement\\ClothesManagement\\uploads\\Fanglong.png\"");
//                Paths.get("/path/to/file")
                byte[] buffer = Files.readAllBytes(filename);
                ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
                return ResponseEntity.ok()
                        .contentLength(buffer.length)
                        .contentType(MediaType.parseMediaType("images/png"))
                        .body(byteArrayResource);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            return ResponseEntity.badRequest().build();
    }
}
