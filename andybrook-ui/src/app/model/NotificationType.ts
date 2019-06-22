export class NotificationType {

    type: string
    supportedFormats: string[]

    constructor() {}

    static fromJson(data: any): NotificationType {
        let notif = new NotificationType();
        notif.type = data.type;
        notif.supportedFormats = data.supportedFormats;
        return notif;
    }
}