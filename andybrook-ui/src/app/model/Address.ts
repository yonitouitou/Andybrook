export class Address {

    streetNumber: string
    streetName: string
    city: string
    country: string
    zipCode: number

    constructor(streetNumber: string, streetName: string, zipCode: number, city: string, country: string) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }

    static fromJson(data: any): Address {
        return new Address(data.streetNumber, data.streetName, data.zipCode, data.city, data.country);
    }

    format(): string {
        return this.streetNumber + ', ' + this.streetName + ' - ' + this.zipCode + ' ' + this.city + ' - ' + this.country;
    }
}