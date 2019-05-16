export class NotificationRequest {

    types: string[] = []
    emails: string[] = []

    constructor(types: string[]) {
        this.types = types;
    }
}