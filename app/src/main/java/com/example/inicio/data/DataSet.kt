package com.example.inicio.data

import com.example.inicio.model.Contact

class DataSet {

    // JAVA: static List<Contact> lista = new ArrayList()
    companion object{
        val lista: List<Contact> = arrayListOf(
            Contact("Contacto1", 123123, "Las rozas", "https://plus.unsplash.com/premium_photo-1690579805307-7ec030c75543?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8cGVyc29uJTIwaWNvbnxlbnwwfHwwfHx8MA%3D%3D"),
            Contact("Contacto2", 123456, "Pozuelo", "https://www.wilsoncenter.org/sites/default/files/media/images/person/james-person-1.jpg"),
            Contact("Contacto3", 456789, "Majadahonda", "https://img.freepik.com/free-photo/lifestyle-people-emotions-casual-concept-confident-nice-smiling-asian-woman-cross-arms-chest-confident-ready-help-listening-coworkers-taking-part-conversation_1258-59335.jpg"),
            Contact("Contacto4", 123789, "Madrid", "https://www.georgetown.edu/wp-content/uploads/2022/02/Jkramerheadshot-scaled-e1645036825432-1050x1050-c-default.jpg"),
            Contact("Contacto5", 634561, "Las Matas", "https://www.indiafilings.com/learn/wp-content/uploads/2023/03/Can-a-single-person-own-a-firm-in-India.jpg")
        )
    }

}