package com.example.recyclerview

class Student(
    private var name: String,
    private var groupNumber: Int,
    private var skillsLevel: Int,
) {
    var fullName: String
        get() {
            return this.name
        }
        set(name) {
            this.name = name
        }

    var group: Int
        get() {
            return this.groupNumber
        }
        set(value) {
            this.groupNumber = value
        }

    var skills: Int
        get() {
            return this.skillsLevel
        }
        set(value) {
            this.skillsLevel = value
        }

}
