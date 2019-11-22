import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../service/login-service';
import {LoggedUser} from "../../model/admin/user/LoggedUser"
import {ModalBuilder} from "../../common-components/modal-builder"
import {InfoModalComponent} from "../../modal/info-modal/info-modal.component"

@Component({
  selector: 'logged-users',
  templateUrl: './logged-users.component.html',
  styleUrls: ['./logged-users.component.css']
})
export class LoggedUsersComponent implements OnInit {

  private loggedUsers: LoggedUser[] = []

  constructor(private loginService: LoginService, private modalBuilder: ModalBuilder) { }

  ngOnInit() {
    this.getLoggedUsers();

  }

  private getLoggedUsers(): void {
    this.loginService.getLoggedUsers().subscribe(
      data => {
        alert(JSON.stringify(data))
        for (let user of data) {
          this.loggedUsers.push(LoggedUser.fromJson(user));
        }
      }, error => {
        let modalRef = this.modalBuilder.open(InfoModalComponent)
        modalRef.componentInstance.title = 'Error';
        modalRef.componentInstance.message = 'Cannot load the logged users : ' + JSON.stringify(error);
      }
    )
  }

}
