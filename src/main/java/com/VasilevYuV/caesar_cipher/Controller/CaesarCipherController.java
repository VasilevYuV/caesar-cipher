package com.VasilevYuV.caesar_cipher.Controller;
import com.VasilevYuV.caesar_cipher.Services.CaesarCipher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Controller
public class CaesarCipherController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("request", new CipherRequest());
        return "index";
    }

    @PostMapping("/updateResult")
    @ResponseBody
    public String updateResult(
            @RequestParam String content,
            @RequestParam int key,
            @RequestParam String language,
            @RequestParam String mode) throws Exception {

        CaesarCipher cipher = new CaesarCipher();
        if ("encryption".equals(mode)) {
            return cipher.encrypt(content, key, language);
        } else {
            return cipher.decrypt(content, key, language);
        }
    }

    @PostMapping("/process")
    public String processFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("language") String language,
            @RequestParam("mode") String mode,
            @RequestParam("key") int key,
            Model model) {

        try {
            String content = new String(file.getBytes(), StandardCharsets.UTF_8);
            CaesarCipher cipher = new CaesarCipher();

            String result;
            if ("encryption".equals(mode)) {
                result = cipher.encrypt(content, key, language);
            } else {
                result = cipher.decrypt(content, key, language);
            }

            model.addAttribute("mode", mode);
            model.addAttribute("original", content);
            model.addAttribute("result", result);
            model.addAttribute("fileName", file.getOriginalFilename());
            model.addAttribute("language", language);
            model.addAttribute("key", key);

        } catch (IOException e) {
            model.addAttribute("error", "Ошибка чтения файла: " + e.getMessage());
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка обработки: " + e.getMessage());
        }

        return "result";
    }

    public static class CipherRequest {
        private String language;
        private String mode;
        private int key;

        // Getters and setters
        public String getLanguage() { return language; }
        public void setLanguage(String language) { this.language = language; }
        public String getMode() { return mode; }
        public void setMode(String mode) { this.mode = mode; }
        public int getKey() { return key; }
        public void setKey(int key) { this.key = key; }
    }
}
