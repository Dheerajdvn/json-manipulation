# String Manipulation Spring Boot Application

## Description
This project demonstrates a simple Spring Boot application that performs string manipulation within a JSON model based on dynamic inputs.

## Requirements
- Java 11 or higher
- Maven
- Spring Boot

## Running the Application
1. Clone the repository
2. Navigate to the project directory
3. Run `mvn spring-boot:run`

## API Endpoints

### Manipulate API Details
- **URL**: `https://IP:PORT/jsonManipulation/api/v1/manipulate`
- **Method**: `GET`
- **Params**: `inputs` (Comma-separated key-value pairs. Examples : `"New:::NewDocument"`, `"New:::NewDocument","Open:::OpenDocument"`)

## Testing
All the testing is done against below JSON Model hard-coded in code:

```json
{
    "menu": {
        "id": "file",
        "value": "File",
        "popup": {
            "menuitem": [
                {
                    "value": "New",
                    "onclick": "CreateDoc()"
                },
                {
                    "value": "Open",
                    "onclick": "OpenDoc()"
                },
                {
                    "value": "Save",
                    "onclick": "SaveDoc()"
                }
            ]
        }
    }
}
```

## Example Request 1 (For null, blank or wrong user input)

	curl --location 'http://localhost:8080/jsonManipulation/api/v1/manipulate?inputStr='

## Example Response
```
Please provide correct user input.
Example inputs:
1. "New:::NewDocument"
2. "New:::NewDocument","Open:::OpenDocument"
```

## Example Request 2 (For single input)

	curl --location 'http://localhost:8080/jsonManipulation/api/v1/manipulate?inputStr=%22New%3A%3A%3ANewDocument%22'

## Example Response
```json
{
    "menu": {
        "id": "file",
        "value": "File",
        "popup": {
            "menuitem": [
                {
                    "value": "NewDocument",
                    "onclick": "CreateDoc()"
                },
                {
                    "value": "OpenDocument",
                    "onclick": "OpenDocumentDoc()"
                },
                {
                    "value": "Save",
                    "onclick": "SaveDoc()"
                }
            ]
        }
    }
}
```

## Example Request 3 (For comma separated multiple inputs)

	curl --location 'http://localhost:8080/jsonManipulation/api/v1/manipulate?inputStr=%22New%3A%3A%3ANewDocument%22%2C%22Open%3A%3A%3AOpenDocument%22'

## Example Response
```json
{
    "menu": {
        "id": "file",
        "value": "File",
        "popup": {
            "menuitem": [
                {
                    "value": "NewDocument",
                    "onclick": "CreateDoc()"
                },
                {
                    "value": "OpenDocument",
                    "onclick": "OpenDocumentDoc()"
                },
                {
                    "value": "Save",
                    "onclick": "SaveDoc()"
                }
            ]
        }
    }
}
```