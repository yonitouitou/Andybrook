import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowOrderItemsModalComponent } from './show-order-items-modal.component';

describe('ShowOrderItemsModalComponent', () => {
  let component: ShowOrderItemsModalComponent;
  let fixture: ComponentFixture<ShowOrderItemsModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowOrderItemsModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowOrderItemsModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
