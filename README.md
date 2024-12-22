# Image to PDF Converter

Welcome to the **Image to PDF Converter**! This Android application allows users to select images from their device and convert them into a single PDF document. Built using Android Studio and Java, this app provides a simple and effective way to organize and share images as PDFs.

## Table of Contents

- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [How It Works](#how-it-works)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Select Multiple Images**: Users can select multiple images from their device's gallery.
- **Convert to PDF**: Convert selected images into a single PDF document with just one click.
- **User-Friendly Interface**: Simple and intuitive UI for seamless user experience.
- **Preview PDF**: View the generated PDF document before saving it.

## Installation

To run this project locally, follow these steps:

1. **Clone the repository**:
	```bash
	git clone https://github.com/RoystonDAlmeida/image-to-pdf-converter.git
	cd image-to-pdf-converter
	```

2. **Open the project in Android Studio**:
Launch Android Studio and open the cloned project.

3. **Set up the environment**:
Ensure you have the latest version of Android Studio installed with the necessary SDKs.

4. **Build the project**:
Click on `Build > Make Project` in the menu bar to compile your application.

5. **Run the application**:
Connect your Android device or start an emulator, then click on the `Run` button in Android Studio.

## Usage

1. **Select Images**:
- Tap on the button to open your device's image gallery.

2. **Convert Images to PDF**:
- After selecting images, tap on the "Convert" button.
- The app will process the images and generate a PDF file.

3. **Save or Share the PDF**:
- Once the PDF is created, you can choose to save it locally or share it via email or other apps.

## How It Works

1. **Image Selection**: The app uses an Intent to open the image gallery and allows users to select multiple images.
2. **Bitmap Conversion**: Selected images are converted into Bitmap format for processing.
3. **PDF Creation**: The app utilizes Android's `PdfDocument` class to create a new PDF document and draw each Bitmap onto its pages.
4. **File Saving**: The generated PDF is saved in the device's storage, making it accessible for sharing or viewing later.

### Example Code Snippet

Here’s a simple code snippet demonstrating how images are converted into a PDF:

	```java
	   {
		    PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder((int) max1, 1300, 1).create();
		    PdfDocument.Page mypage1 = pdfDocument.startPage(pageInfo);
		    Canvas canvas = mypage1.getCanvas();
		    scaledbitmap = Bitmap.createScaledBitmap(bitmap, (int) max1, 1300, true);

		    canvas.drawBitmap(scaledbitmap, 2, 1, paint);
		    pdfDocument.finishPage(mypage1);
		    
		    pdfDocument.writeTo(new FileOutputStream(file1));
	    }
	```


## Contributing

We welcome contributions! To contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/YourFeature`).
3. Make your changes and commit them (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeature`).
5. Open a pull request.

Please ensure that your code adheres to our coding standards and includes appropriate tests.

## License

This project is licensed under the MIT License - see the [LICENSE](https://opensource.org/licenses/MIT) file for details.

---

Thank you for checking out our Image to PDF Converter! We hope you find it useful and engaging. If you have any questions or feedback, feel free to reach out!
