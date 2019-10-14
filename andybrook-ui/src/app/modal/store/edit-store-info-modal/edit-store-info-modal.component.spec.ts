import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditStoreInfoModalComponent } from './edit-store-info-modal.component';

describe('EditStoreInfoModalComponent', () => {
  let component: EditStoreInfoModalComponent;
  let fixture: ComponentFixture<EditStoreInfoModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditStoreInfoModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditStoreInfoModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
