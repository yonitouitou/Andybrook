export class ActuatorSessions {
    sessions: ActuatorSession[] = []

    constructor() {}

    private addSession(session: ActuatorSession) {
        this.sessions.push(session)
    }

    static fromJson(data: any): ActuatorSessions {
        let sessions = new ActuatorSessions()
        for (let session of data.sessions) {
            sessions.addSession(ActuatorSession.fromJson(session))
        }
        return sessions
    }

}

export class ActuatorSession {
    private id: string
    private attributeNames: string[] = []
    private creationTime: string
    private lastAccessedTime: string
    private maxInactiveInterval: number
    private expired: boolean

    constructor() {}

    static fromJson(data: any): ActuatorSession {
        let session = new ActuatorSession()
        session.id = data.id
        session.attributeNames = data.attributeNames
        session.creationTime = data.creationTime
        session.lastAccessedTime = data.lastAccessedTime
        session.maxInactiveInterval = data.maxInactiveInterval
        session.expired = data.expired
        return session
    }
}