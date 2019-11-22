import {SessionInfo} from "./SessionInfo"

export class LoggedUser {
  username: string
  sessions: SessionInfo[] = []

  constructor() {}

  static fromJson(data: any): LoggedUser {
    let loggedUser = new LoggedUser()
    loggedUser.username = data.username
    for (let sessionInfo of data.sessionsInfo) {
      loggedUser.sessions.push(SessionInfo.fromJson(sessionInfo));
    }
    return loggedUser
  }
}
