import { Component, OnInit } from '@angular/core';
import { AdminSettingService } from '../../service/admin-setting-service'
import { AdminSetting } from 'src/app/model/admin/AdminSetting';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subject } from 'rxjs'
import { debounceTime } from 'rxjs/operators'

@Component({
  selector: 'admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent implements OnInit {

  private _success = new Subject<string>()
  private adminSetting: AdminSetting
  adminForm: FormGroup;
  submitted = false;
  saveButtonDisabled = true

  alertMessage: string

  constructor(private formBuilder: FormBuilder,
              private adminSettingService: AdminSettingService) { }

  ngOnInit() {
    this.adminForm = this.formBuilder.group({
      notification: [],
      emails: [, [Validators.required]]
    });

    this.adminSetting = new AdminSetting()
    this.adminSettingService.getAdminSetting(this.adminSetting)
        .subscribe(data => {
          this.adminSetting.emails = data.emails
          this.adminSetting.notifyOnCloseReport = data.notificationPolicy.onCloseReport

          this.adminForm.setValue({
            notification: this.adminSetting.notifyOnCloseReport,
            emails: this.adminSetting.emails
      })
    })

    this._success.subscribe((msg) => this.alertMessage = msg)
    this._success.pipe(debounceTime(5000)).subscribe(() => this.alertMessage = null)
  }

  public changeAlertMessage() {
    this._success.next("Setting saved successully")
  }

  settingChanged() {
    this.saveButtonDisabled = false
  }

  settingSaved() {
    this.saveButtonDisabled = true
    this.changeAlertMessage()
  }

  // convenience getter for easy access to form fields
  get f() { return this.adminForm.controls; }

  onSubmit() {
      this.submitted = true;
      if (this.adminForm.invalid) {
          return;
      }
      let values = this.adminForm.value
      this.adminSetting.emails = values.emails.split(",")
      this.adminSetting.notifyOnCloseReport = values.notification
      this.adminSettingService.updateAdminSetting(this.adminSetting)
      this.settingSaved()

  }
}
