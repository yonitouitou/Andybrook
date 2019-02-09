import { Component, OnInit } from '@angular/core';
import { AdminSettingService } from '../../service/admin-setting-service'
import { AdminSetting } from 'src/app/model/admin/AdminSetting';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent implements OnInit {

  private adminSetting: AdminSetting
  adminForm: FormGroup;
  submitted = false;
  saveButtonDisabled = true

  constructor(private formBuilder: FormBuilder,
              private adminSettingService: AdminSettingService) { }

  ngOnInit() {
    this.adminForm = this.formBuilder.group({
      notification: [],
      email: [, [Validators.required, Validators.email]]
    });

    this.adminSetting = new AdminSetting()
    this.adminSettingService.getAdminSetting(this.adminSetting)
        .subscribe(data => {
          this.adminSetting.email = data.email
          this.adminSetting.notifyOnCloseReport = data.notificationPolicy.onCloseReport

          this.adminForm.setValue({
            notification: this.adminSetting.notifyOnCloseReport,
            email: this.adminSetting.email
      })
    })
  }

  settingChanged() {
    this.saveButtonDisabled = false
  }

  settingSaved() {
    this.saveButtonDisabled = true
  }

  // convenience getter for easy access to form fields
  get f() { return this.adminForm.controls; }

  onSubmit() {
      this.submitted = true;
      if (this.adminForm.invalid) {
          return;
      }
      let values = this.adminForm.value
      this.adminSetting.email = values.email
      this.adminSetting.notifyOnCloseReport = values.notification
      this.adminSettingService.updateAdminSetting(this.adminSetting)
      this.settingSaved()
  }
}
