# Fawry Rise Journey Internship Challenge

## Overview
This project simulates a simple e-commerce system using Java, showcasing:
- Object-Oriented Design
- Interface Segregation
- Edge-case handling
- Realistic checkout behavior

## Features
- Products with optional `Expirable` and `Shippable` traits
- Strict validation on stock, expiry, and balance
- Grouped shipping notices (as per the sample)
- Clean and testable `Main` with all edge cases

##  OOP Concepts Used
- `abstract` base class for `Product`
- Marker Interfaces: `Shippable`, `Expirable`
- Composition and Polymorphism in action

## Edge Cases Tested
1.  Valid checkout
2. Empty cart
3. Expired product
4. Quantity exceeds stock
5.  Insufficient balance
6.  Product that doesn't require shipping or expiry

