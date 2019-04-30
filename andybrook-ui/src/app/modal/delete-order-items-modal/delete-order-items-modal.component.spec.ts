import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteOrderItemsModalComponent } from './delete-order-items-modal.component';

describe('DeleteOrderItemsModalComponent', () => {
  let component: DeleteOrderItemsModalComponent;
  let fixture: ComponentFixture<DeleteOrderItemsModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteOrderItemsModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteOrderItemsModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
