export class NotificationRequest {

    docType: string
    emails: string[] = []

    constructor(docType: string) {
        this.docType = docType;
    }
}