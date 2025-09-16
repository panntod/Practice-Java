## 🔑 SOLID Principles

**1. S — Single Responsibility Principle (SRP)**

* **Definisi**: Setiap class hanya boleh memiliki **satu alasan untuk berubah**, artinya satu class harus punya **satu tanggung jawab utama**.
* **Koreksi dari penjelasanmu**: Bukan berarti "satu class hanya boleh punya satu method", melainkan satu class fokus pada satu peran saja.
* **Contoh**:

  ```java
  // ❌ Salah: Banyak tanggung jawab dalam satu class
  class User {
      void saveToDatabase() { ... }
      void logActivity() { ... }
      void sendEmail() { ... }
  }

  // ✅ Benar: Pisahkan tanggung jawab
  class User { ... }
  class UserRepository {
      void save(User user) { ... }
  }
  class UserLogger {
      void log(User user) { ... }
  }
  ```

---

**2. O — Open/Closed Principle (OCP)**

* **Definisi**: Class harus **open for extension** (bisa dikembangkan) tapi **closed for modification** (tidak perlu diubah ketika menambah fitur baru).
* **Contoh**:

  ```java
  // ❌ Salah: harus edit method kalau ada role baru
  class Worker {
      String role;
      void work() {
          if (role.equals("Manager")) { ... }
          else if (role.equals("Engineer")) { ... }
      }
  }

  // ✅ Benar: gunakan inheritance/polymorphism
  abstract class Worker {
      abstract void work();
  }
  class Manager extends Worker {
      void work() { ... }
  }
  class Engineer extends Worker {
      void work() { ... }
  }
  ```

---

**3. L — Liskov Substitution Principle (LSP)**

* **Definisi**: Subclass harus bisa menggantikan superclass tanpa mengubah kebenaran logika program.
* **Maksudnya**: Kalau `B` adalah turunan dari `A`, maka objek `B` bisa dipakai di mana saja objek `A` digunakan, tanpa masalah.
* **Contoh**:

  ```java
  // ❌ Salah: Burung unta tidak bisa terbang, tapi dipaksa punya method fly()
  class Bird {
      void fly() { ... }
  }
  class Ostrich extends Bird {
      void fly() { throw new UnsupportedOperationException(); }
  }

  // ✅ Benar: gunakan abstraksi yang tepat
  abstract class Bird { }
  interface Flyable { void fly(); }

  class Sparrow extends Bird implements Flyable {
      public void fly() { ... }
  }
  class Ostrich extends Bird { 
      // tidak perlu fly()
  }
  ```

---

**4. I — Interface Segregation Principle (ISP)**

* **Definisi**: Jangan membuat interface yang "gemuk" (terlalu banyak method). Lebih baik pecah menjadi interface kecil agar class hanya mengimplementasikan apa yang dibutuhkannya.
* **Contoh**:

  ```java
  // ❌ Salah: interface terlalu besar
  interface Worker {
      void work();
      void eat();
      void sleep();
  }

  // ✅ Benar: pisahkan sesuai tanggung jawab
  interface Workable { void work(); }
  interface Eatable { void eat(); }

  class Robot implements Workable {
      public void work() { ... }
  }
  class Human implements Workable, Eatable {
      public void work() { ... }
      public void eat() { ... }
  }
  ```

---

**5. D — Dependency Inversion Principle (DIP)**

* **Definisi**: High-level module (class yang lebih abstrak) **tidak boleh langsung bergantung ke low-level module**, melainkan keduanya harus bergantung pada **abstraksi** (interface/abstract class).
* **Contoh**:

  ```java
  // ❌ Salah: Class tinggi langsung bergantung ke implementasi
  class MySQLDatabase {
      void save(String data) { ... }
  }
  class UserService {
      private MySQLDatabase db = new MySQLDatabase();
      void saveUser(String data) {
          db.save(data);
      }
  }

  // ✅ Benar: bergantung ke abstraksi
  interface Database {
      void save(String data);
  }
  class MySQLDatabase implements Database {
      public void save(String data) { ... }
  }
  class MongoDatabase implements Database {
      public void save(String data) { ... }
  }

  class UserService {
      private Database db;
      UserService(Database db) { this.db = db; }
      void saveUser(String data) {
          db.save(data);
      }
  }
  ```

Dengan ini, kalau mau ganti database dari MySQL ke Mongo, kamu tidak perlu ubah `UserService`, cukup inject implementasi baru.

---

👉 Jadi, SOLID **bukan design pattern**, melainkan **prinsip desain** (guidelines) yang diperkenalkan oleh Robert C. Martin (Uncle Bob) jauh sebelum 2014 (sekitar awal 2000-an). Prinsip ini relevan sampai sekarang di berbagai bahasa OOP (Java, C#, Python, Go, dll).

---