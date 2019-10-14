import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { Store } from '../../../model/Store';
import { ModalBuilder } from '../../../common-components/modal-builder';
import { StoreService } from '../../../service/store-service';
import { EditStoreInfoModalComponent } from '../../../modal/store/edit-store-info-modal/edit-store-info-modal.component';

@Component({
  selector: 'store-info',
  templateUrl: './store-info.component.html',
  styleUrls: ['./store-info.component.css']
})
export class StoreInfoComponent implements OnChanges {

  @Input()
  private storeId: number
  private store: Store
  
  constructor(private storeService: StoreService, private modalBuilder: ModalBuilder) { }

  
  ngOnChanges() {
    if (this.storeId != null) {
      this.refresh()
    }
  }

  private refresh(): void {
    this.store = null
    this.storeService.get(this.storeId).subscribe(
      data => {
        this.store = Store.fromJson(data)
      }
    )
  }

  editStoreInfo(): void {
    let modal = this.modalBuilder.openCenteredModal(EditStoreInfoModalComponent)
    modal.componentInstance.store = this.store
    modal.result.then((response) => {
      if (response) {
        this.refresh()
      }
    })
  }

}
