# File Sharer - Secure P2P File Sharing
<<<<<<< HEAD

A modern, secure peer-to-peer file sharing application built with Java (backend) and Next.js (frontend). Share files directly between users with PIN-based authentication.

=======

A modern, secure peer-to-peer file sharing application built with Java (backend) and Next.js (frontend). Share files directly between users with PIN-based authentication.
>>>>>>> f2a4e1548784ac35e480039f2d02e55f27241fc4

## 🔧 Tech stack

- **Backend:** Java (built with Maven), uses the built-in `com.sun.net.httpserver` and Apache Commons IO/FileUpload.
- **Frontend:** Next.js + React (in the `ui/` folder).


## 🚀 Features

<<<<<<< HEAD
- 🔐 **PIN-Based Authentication:** Each upload generates a unique 6-digit PIN for secure access
- ⚡ **Real-Time P2P Transfer:** Direct file transfer between peers without centralized storage
- 📁 **Multiple File Types:** Currently supports for pdf, txt and json.
- 🚀 **Fast & Lightweight:** Minimal dependencies, optimized for performance
- 📊 **File Size Control:** 100MB upload limit with streaming validation
- 🔒 **Thread-Safe:** Concurrent request handling with proper synchronization


## 🏗️ Architecture & Concepts

### Peer-to-Peer (P2P) Architecture

PeerLink implements a hybrid P2P model:

- **Central Coordinator:** Backend server manages file metadata and authentication
- **Direct Transfer:** Actual file data flows directly between peers via TCP sockets
- **Dynamic Ports:** Each file sharing session uses a unique, randomly assigned port

```
┌─────────┐         ┌──────────────┐         ┌───────────┐
│ Uploader│◄───────►│ Backend      │◄───────►│Downloader │
│         │ Metadata│ (Java API)   │ Metadata│           |
└────┬────┘         └──────────────┘         └─────┬─────┘
     │                                             │
     │    Direct P2P Transfer                      │
     └─────────────────────────────────────────────┘
                    (TCP Socket)
```


2. **Multi-Layered Security** Defense in Depth Approach:

- **Network Layer:** Port validation (1024-65535), socket timeouts
- **Application Layer:** Rate limiting, content-type validation
- **Authentication Layer:** PIN-based access control
- **Data Layer:** File size limits, sanitization


3. **Concurrent Request Handling**

- **ConcurrentHashMap:** Thread-safe storage for file metadata and tokens
- **ExecutorService:** Thread pool for handling multiple simultaneous requests
- **Atomic Operations:** Race-condition-free counter updates for rate limiting


4. **Streaming Architecture**

Files are processed using streaming rather than loading entirely into memory:

- 8KB buffer for efficient data transfer
- Real-time size validation during upload
- Memory footprint independent of file size


5. **RESTful API Design**

Clean, stateless API endpoints following REST principles:

- `POST /api/upload` - Upload file and receive PIN
- `GET /api/download?token={PIN}` - Download file with PIN authentication


## 🛠️ Technology Stack

- **Backend Java 17:** Modern Java features including records, text blocks, var
- **HTTP Server:** Built-in `com.sun.net.httpserver` for lightweight HTTP handling
- **Maven:** Dependency management and build automation
- **Apache Commons IO:** Stream utilities for efficient file handling
- **Frontend Next.js 14:** React framework with server-side rendering
- **TypeScript:** Type-safe JavaScript for better developer experience
- **Tailwind CSS:** Utility-first CSS framework for rapid UI development
- **Axios:** HTTP client for API communication
- **React Icons:** Modern icon library

=======
🔐 PIN-Based Authentication: Each upload generates a unique 6-digit PIN for secure access
⚡ Real-Time P2P Transfer: Direct file transfer between peers without centralized storage
📁 Multiple File Types: Currently supports for pdf, txt and json.
🚀 Fast & Lightweight: Minimal dependencies, optimized for performance
📊 File Size Control: 100MB upload limit with streaming validation
🔒 Thread-Safe: Concurrent request handling with proper synchronization

🏗️ Architecture & Concepts
1. Peer-to-Peer (P2P) Architecture
PeerLink implements a hybrid P2P model:

Central Coordinator: Backend server manages file metadata and authentication
Direct Transfer: Actual file data flows directly between peers via TCP sockets
Dynamic Ports: Each file sharing session uses a unique, randomly assigned port
┌─────────┐         ┌──────────────┐         ┌───────────┐
│ Uploader│◄───────►│   Backend    │◄───────►│Downloader │
│         │ Metadata│  (Java API)  │ Metadata│           │
└────┬────┘         └──────────────┘         └─────┬─────┘
     │                                             │
     │          Direct P2P Transfer                │
     └─────────────────────────────────────────────┘
                  (TCP Socket)
2. Multi-Layered Security
Defense in Depth Approach:

Network Layer: Port validation (1024-65535), socket timeouts
Application Layer: Rate limiting, content-type validation
Authentication Layer: PIN-based access control
Data Layer: File size limits, sanitization
3. Concurrent Request Handling
ConcurrentHashMap: Thread-safe storage for file metadata and tokens
ExecutorService: Thread pool for handling multiple simultaneous requests
Atomic Operations: Race-condition-free counter updates for rate limiting
4. Streaming Architecture
Files are processed using streaming rather than loading entirely into memory:

8KB buffer for efficient data transfer
Real-time size validation during upload
Memory footprint independent of file size
5. RESTful API Design
Clean, stateless API endpoints following REST principles:

POST /api/upload - Upload file and receive PIN
GET /api/download?token={PIN} - Download file with PIN authentication


## 🛠️ Technology Stack
Backend
Java 17: Modern Java features including records, text blocks, var
HTTP Server: Built-in com.sun.net.httpserver for lightweight HTTP handling
Maven: Dependency management and build automation
Apache Commons IO: Stream utilities for efficient file handling
Frontend
Next.js 14: React framework with server-side rendering
TypeScript: Type-safe JavaScript for better developer experience
Tailwind CSS: Utility-first CSS framework for rapid UI development
Axios: HTTP client for API communication
React Icons: Modern icon library
>>>>>>> f2a4e1548784ac35e480039f2d02e55f27241fc4

## Getting started

### Run the backend

**Build the backend:**

```powershell
mvn compile
```

**Run the server (from the project root):**

```powershell
java -cp target/classes Main
```

The API server listens on port 8080 and prints a message on startup. You can stop it by entering `exit` in the console.


### Run the UI

**Change into the UI folder and install dependencies:**

```powershell
cd ui; npm install
```

**Start the dev server:**

```powershell
npm run dev
```

The Next.js app will be available at http://localhost:3000 by default.


## Usage examples

**Upload a file with curl:**

```bash
curl -F "file=@/path/to/file" http://localhost:8080/upload
# returns: { "port": 49152 }
```

**Download the file using the returned port:**

```bash
curl -L http://localhost:8080/download/49152 -o received-file
```


## Troubleshooting & notes ⚠️

- The backend binds the ephemeral file servers to random ports generated by `UploadUtils.generateCode()` (range from the code: 49152+). Ensure your firewall allows those ports and they are not in use.
- The server writes temporary uploads to the system temp directory under `peerlink-uploads`.
- The project is a demo / learning project and does not include production-grade security features.


## Contributing

Contributions, bug reports and PRs are welcome. Please open issues or PRs on the repo.
<<<<<<< HEAD
=======

>>>>>>> f2a4e1548784ac35e480039f2d02e55f27241fc4
