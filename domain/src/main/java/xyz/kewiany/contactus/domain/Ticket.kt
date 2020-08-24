package xyz.kewiany.contactus.domain

class Ticket(
    val email: Email,
    val name: Name,
    val country: Country,
    val topic: Topic
) {
    companion object {
        fun create(
            email: String,
            name: String,
            country: Country,
            topic: Topic
        ): Ticket = Ticket(
            Email(email),
            Name(name),
            country,
            topic
        )
    }
}

data class Email(val value: String)
data class Name(val value: String)
