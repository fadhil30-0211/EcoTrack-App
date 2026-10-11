# Implementation Plan - Feature Refinement and Interaction

This plan focuses on refining the placeholder screens (Map, History) and adding interactive elements to the forms (Registration, Report) to make the app more functional and aligned with the mockup.

## Proposed Changes

### UI Refinement
- **MapFragment**: Implement the map area with visual "pins" using custom views/drawables as placeholders for actual Google Maps.
- **HistoryFragment**: Enhance the list items and implement filter tab logic (visual only).
- **ReportActivity**: Implement category chip selection logic.
- **RegistrationActivity**: Implement role chip selection logic.

### Interaction & Validation
- Add basic validation for Login and Registration fields.
- Ensure all "Back" buttons work consistently.

## Detailed Steps

### [res/drawable]
- [NEW] `bg_chip_category.xml`: Selector for report categories.
- [NEW] `bg_map_pin.xml`: Shape for map pins.

### [res/layout]
- `fragment_map.xml`: Add placeholder map pins and stylized roads (using Views).
- `fragment_history.xml`: Ensure it uses `item_history` correctly.

### [Activities & Fragments]
- `RegistrationActivity.kt`: Add logic to toggle roles.
- `ReportActivity.kt`: Add logic to toggle categories and urgency.
- `HistoryFragment.kt`: Handle filter tab clicks (visual updates).

## Verification Plan
### Manual Verification
- Navigate through all screens to ensure no crashes.
- Test role selection in Registration.
- Test category selection in Report.
- Verify back button functionality on all activities.
