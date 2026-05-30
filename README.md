# Android User Info Form App (v2.0)

An interactive, responsive Android application designed to collect, validate, and process user profile data. This project has been upgraded from a static layout playground into a fully functional, production-ready mobile interface.

---

## 🆙 What's New in Version 2.0

We completely overhauled the app's structural layout code and introduced a robust backend logic engine to bring the interface to life.

### 🛠️ 1. XML Layout Optimizations
- **From Text to Hints:** Swapped out disruptive `android:text` properties for **`android:hint`** placeholders. Users no longer have to delete default text manually before typing.
- **Performance-Driven Layout Weights:** Fixed horizontal rendering constraints by setting `android:layout_width="0dp"` on proportional header elements, forcing Android to calculate screen space smoothly.
- **Alignment Refinements:** Added `android:gravity="center_vertical"` to the header bar to keep the star icon and title text perfectly balanced along a uniform horizontal axis.

### ☕ 2. Backend Java Integration
- **Dynamic Field Mapping:** Connected the XML visual interface directly to Java logic using clean view binding via **`findViewById`**.
- **Sequential Input Validation:** Programmed an interactive verification engine that scans input fields upon submission. Missing inputs are caught instantly using focused **`.setError()`** warnings and cursor requests.
- **Action Feedbacks:** Integrated native Android **`Toast`** popup banners to provide immediate feedback to the user when a profile saves successfully.

---

## 📐 Application Architecture & Layout

The user interface utilizes a vertical `LinearLayout` containing three modular layout components structured as follows:

```text
[ Root Vertical LinearLayout ]
   ├── Header Layout (Horizontal)  ⟶  ImageView (Star) + Title TextView ("User Info")
   ├── Form Container (Vertical)    ⟶  4 x Custom Data Inputs (Name, Phone, Email, Dept)
   └── Interactive Action Button    ⟶  "Save User Info" Trigger