export class SessionInfo {

  sessionId: string
  lastLoginDatetime: Date

  constructor() {}

  static fromJson(data: any) {
    let session = new SessionInfo()
    session.sessionId = data.sessionId
    session.lastLoginDatetime = new Date(data.lastLoginDatetime)
    return session
  }
}
