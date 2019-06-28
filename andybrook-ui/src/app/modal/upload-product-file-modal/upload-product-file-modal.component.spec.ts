import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UploadProductFileModalComponent } from './upload-product-file-modal.component';

describe('UploadProductFileModalComponent', () => {
  let component: UploadProductFileModalComponent;
  let fixture: ComponentFixture<UploadProductFileModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UploadProductFileModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UploadProductFileModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
