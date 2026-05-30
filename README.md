# Android User Info Page (Layout Basics)

A simple, clean Android XML layout designed to collect and display user information. This project serves as a practical implementation of fundamental Android UI layout principles.

## Learning Objectives

This repository demonstrates a foundational understanding of:
- **Nested Layouts:** Structuring a UI using a parent `LinearLayout` with child layout components.
- **Orientation Control:** Utilizing both `vertical` and `horizontal` linear arrangements.
- **Spacing Mechanics:** Implementing `android:layout_margin` for outer element separation and `android:padding` for internal spacing.
- **Attributes:** Working with `layout_weight`, dimensions (`dp`), and text sizes (`sp`).

---

## 🛠️ UI Features & Structure

The screen is built entirely using a vertical `LinearLayout` containing three distinct layout zones:

### 1. Header Bar (`Horizontal` LinearLayout)
- **Background:** Vibrant red color wrapper (`#E24141`).
- **Elements:** Features a star `ImageView` paired with a bold, 50sp "User Info" title `TextView`. Both share an even weight distribution (`layout_weight="1"`).

### 2. Form Inputs (`Vertical` LinearLayout)
- Isolated from screen edges via a `10dp` external margin and wrapped in a `10dp` internal padding to buffer inputs cleanly.
- Consists of 4 distinct `EditText` field components:
    - Name
    - Phone No.
    - Email
    - Department
- Each field is separated using a `12dp` top margin for a clean, non-cluttered reading experience.

### 3. Action Button
- A full-width `Button` wrapped with a green background accent (`#4CAF50`).
- Styled with consistent margins and padding to ensure a prominent hit target.

---

## 📐 Margins vs Paddings: Key Takeaway

A core focus of this project was mastering the distinction between spacing types:
- **Margin:** Controls the space *outside* the boundary of an element (e.g., pushing the input fields away from the screen edge).
- **Padding:** Controls the space *inside* the element (e.g., buffering text away from its own borders).

---