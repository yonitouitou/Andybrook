export class ActuatorDbHealth {

    isUp: boolean
    dbName: string
    error: string

    constructor() {}

    static fromJson(data: any): ActuatorDbHealth {
        let health = new ActuatorDbHealth()
        health.isUp = data.status == 'UP'
        health.dbName = data.details.database == null ? '' : data.details.database
        health.error = data.details.error
        return health
    }
}