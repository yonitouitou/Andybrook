export class DocType {

    type: string
    supportedFormats: string[]

    constructor() {}

    static fromJson(data: any): DocType {
        let notif = new DocType();
        notif.type = data.type;
        notif.supportedFormats = data.supportedFormats;
        return notif;
    }
}