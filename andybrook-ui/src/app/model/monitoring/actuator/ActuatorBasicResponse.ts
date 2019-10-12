export class ActuatorBasicResponse {
    
    name: string
    baseUnit: string
    values: string[] = []
    description: string

    constructor() {}

    static fromJson(data: any): ActuatorBasicResponse {
        let res = new ActuatorBasicResponse()
        res.name = data.name
        res.baseUnit = data.baseUnit != null ? data.baseUnit : ""
        res.description = data.description
        for (const val of data.measurements) {
            res.values.push(val.value)
        }
        return res
    }

}