# ConvertWordToPdf
Este proyecto proporciona una API REST en Java para convertir archivos de Word (.doc, .docx) a formato PDF. Se trata de un proyecto de prueba de conceptos que explora diferentes bibliotecas para la conversión de documentos y ofrece la flexibilidad de utilizar Aspose o Spire para realizar la conversión, brindando opciones para diversas necesidades.

## Tabla de Contenidos

- [Introducción](#introducción)
- [Funcionalidades](#funcionalidades)
- [Tecnologías](#tecnologías)
- [Instalación](#instalación)
- [Uso](#uso)
- [Endpoints de la API](#endpoints-de-la-api)
- [Ejemplo de Solicitud](#ejemplo-de-solicitud)


## Introducción

Este proyecto facilita la conversión de documentos de Word a PDF de manera sencilla y eficiente. La API REST permite integrar la funcionalidad de conversión en diversas aplicaciones y plataformas.

## Funcionalidades

- Conversión de archivos .doc y .docx a PDF.
- Soporte para proveedores de conversión Aspose y Spire.
- API RESTful para una fácil integración.
- Manejo de errores y respuestas claras.

## Tecnologías

- Java
- Spring Boot
- [Lista de dependencias](#librerías-utilizadas)

## Webs:
- https://www.e-iceblue.com/Download/doc-for-java-free.html
- https://products.aspose.cloud/words/es/nodejs/conversion/word-to-pdf/

## Instalación

1.  **Clona el repositorio:**

    ```bash
    git clone [https://github.com/Guerrero7557/ConvertWordToPdf.git](https://github.com/Guerrero7557/ConvertWordToPdf.git)
    ```

2.  **Construye el proyecto con Maven:**

    ```bash
    cd ConvertWordToPdf
    mvn clean install
    ```

3.  **Ejecuta la aplicación:**

    ```bash
    java -jar target/ConvertWordToPdf-*.jar
    ```

## Uso

Una vez que la aplicación está en ejecución, puedes interactuar con la API REST utilizando herramientas como `curl` o Postman.

## Endpoints de la API

-   `POST /convertFilePdf/convert/{proveedor}-word-to-pdf`: Convierte un archivo de Word a PDF utilizando el proveedor especificado (`aspose` o `spire`).

## Ejemplo de Solicitud (usando `curl`)

```bash
curl -X POST \
  -F "file=@/ruta/al/archivo.docx" \
  http://localhost:8095/convertFilePdf/convert/aspose-word-to-pdf
