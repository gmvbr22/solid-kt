package dev.gmvbr.solid

// wrong
// Se você tentar criar um novo view para o client, terá que modificar o Client
// Assim violando o princípio

class DesktopView {
    fun showDesktopVersion() {}
}

class WebView {
    fun showWebVersion() {}
}

class Client {

    fun show(type: Any) {
        if (type is DesktopView) {
            return type.showDesktopVersion()
        }
        if (type is WebView) {
            return type.showWebVersion()
        }
    }
}

// correct
// Você pode adicionar um novo tipo de visualização, tornando aberto a extensão
// Apenas implementando a interface ClientView, não precisando modificar o Device

interface ClientView {
    fun showView()
}

class DesktopClient : ClientView {
    override fun showView() {}

}

class WebClient : ClientView {
    override fun showView() {}
}

class Device {
    fun show(client: ClientView) {
        client.showView()
    }
}