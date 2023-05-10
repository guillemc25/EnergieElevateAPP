package com.example.energieelevate

import java.sql.*

class DBConnection {
    private val url = "db4free.net"
    private val username = "guille"
    private val password = "ManzaGuille789"
    private var connection: Connection? = null

    fun connect(): Connection? {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver")
            connection = DriverManager.getConnection(url, username, password)
        } catch (e: SQLException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
        return connection
    }

    fun disconnect() {
        connection?.close()
    }

    fun InsertarUsuario(nombre: String, apellidos: String, nombreUsuario: String, correoElectronico: String, contrasena: String): Boolean {
        var success = false
        val sql = "INSERT INTO usuario (Nombre, Apellidos, Usuario, Correo_Electronico, Contrasena) VALUES (?, ?, ?, ?, ?)"
        try {
            val conn = connect()
            val stmt = conn?.prepareStatement(sql)
            stmt?.setString(1, nombre)
            stmt?.setString(2, apellidos)
            stmt?.setString(3, nombreUsuario)
            stmt?.setString(4, correoElectronico)
            stmt?.setString(5, contrasena)
            val rows = stmt?.executeUpdate()
            if (rows != null && rows > 0) {
                success = true
            }
            disconnect()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return success
    }

}
