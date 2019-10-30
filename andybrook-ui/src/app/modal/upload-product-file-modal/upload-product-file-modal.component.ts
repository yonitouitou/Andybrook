import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { FileUploader, FileItem, ParsedResponseHeaders } from 'ng2-file-upload';
import { UploadProductsFileResult } from 'src/app/model/UploadProductsFileResult';
import { ProductService } from '../../service/product-service';

@Component({
  selector: 'upload-product-file-modal',
  templateUrl: './upload-product-file-modal.component.html',
  styleUrls: ['./upload-product-file-modal.component.css']
})
export class UploadProductFileModalComponent implements OnInit {

  @ViewChild('fileInput', {static: false}) fileInput: ElementRef;

  private result: UploadProductsFileResult
 
  uploader: FileUploader;
  isDropOver: boolean;
  showConfirmUploadButton: boolean = false;

  constructor(private productService: ProductService){}
 
  ngOnInit(): void {
    const headers = [{name: 'Accept', value: 'application/json'}];
    this.uploader = new FileUploader({
      url: 'v1/productItemFileUpload/upload',
      autoUpload: true,
      headers: headers
    });
    this.uploader.onErrorItem = (item, response, status, headers) => this.onErrorItem(item, response, status, headers);
    this.uploader.onSuccessItem = (item, response, status, headers) => this.onSuccessItem(item, response, status, headers);
  }

  onSuccessItem(item: FileItem, response: string, status: number, headers: ParsedResponseHeaders) {
    this.result = UploadProductsFileResult.fromJson(JSON.parse(response));
    this.showConfirmUploadButton = true;
  }
  onErrorItem(item: FileItem, response: string, status: number, headers: ParsedResponseHeaders){
      alert('Error : ' + JSON.stringify(response)); //error server response
      this.showConfirmUploadButton = false;
  }
 
  fileOverAnother(e: any): void {
    this.reset();
    this.isDropOver = e;
  }
 
  fileClicked() {
    this.fileInput.nativeElement.click();
  }

  onClickYes() {
    this.productService.confirmProductItemFileUpload(this.result.id).subscribe(
      data => {
        this.reset();
      }
     )

  }

  onClickNo() {
    alert('no');
  }

  private reset() {
    this.result = null;
  }

}
