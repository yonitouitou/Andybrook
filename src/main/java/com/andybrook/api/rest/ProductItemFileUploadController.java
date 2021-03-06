package com.andybrook.api.rest;

import com.andybrook.manager.api.IProductItemFileParserManager;
import com.andybrook.model.api.StockItemsFileUpload;
import com.andybrook.util.file.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("v1/productItemFileUpload")
public class ProductItemFileUploadController extends AbstractController {

    @Autowired
    private IProductItemFileParserManager productItemFileParserManager;

    @PostMapping(value = "/upload")
    public StockItemsFileUpload uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        File uploadedFile = FileUtil.writeToFile(file.getInputStream(), file.getOriginalFilename());
        return productItemFileParserManager.parseCsvFile(uploadedFile);
    }

    @PutMapping(value = "/upload-confirm/{uploadId}")
    public void confirmUploadFile(@PathVariable String uploadId) {
        productItemFileParserManager.processUpload(uploadId);
    }
}
