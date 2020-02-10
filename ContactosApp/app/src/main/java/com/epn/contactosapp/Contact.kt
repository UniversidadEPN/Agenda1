package com.epn.contactosapp




class Contact {

    var id: Int = 0
    var name: String=""
    var phoneNumber: String=""


    constructor() {}

    constructor(id: Int, name: String, _phone_number: String) {
        this.id = id
        this.name = name
        this.phoneNumber = _phone_number
    }

    constructor(name: String, _phone_number: String) {
        this.name = name
        this.phoneNumber = _phone_number
    }





}