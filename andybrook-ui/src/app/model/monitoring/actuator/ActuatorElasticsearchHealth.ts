import { debug } from "util"

export class ActuatorElasticsearchHealth {

    isUp: boolean
    clusterName: string
    elasticsearchStatus: string
    nodesNb: number
    dataNodesNb: number
    activePrimaryShardsNb: number
    activeShardsNb: number
    pendingTaskNb: number
    error: string

    constructor() {}

    static fromJson(data: any): ActuatorElasticsearchHealth {
        let health = new ActuatorElasticsearchHealth()
        health.isUp = data.status == 'UP'
        health.clusterName = data.details.cluster_name
        health.elasticsearchStatus = data.details.status
        health.nodesNb = data.details.number_of_nodes
        health.dataNodesNb = data.details.number_of_data_nodes
        health.activePrimaryShardsNb = data.details.active_primary_shards
        health.activeShardsNb = data.details.active_shards
        health.pendingTaskNb = data.details.number_of_pending_tasks
        health.error = data.error
        return health
    }
}