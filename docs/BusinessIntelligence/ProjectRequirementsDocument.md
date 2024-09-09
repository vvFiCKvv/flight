# Project Requirements Document

- This is **thought experiment** to practice and validate some Business intelligence theory.

## Purpose

As part of the prediction validation, the AI Team has asked for a dashboard to track the difference between predicted vs reality for booking volumes an prices. The goal is to provide insights in order to  optimize the flight prediction system.

## Key dependencies

The datasets are fictionalized versions of the actual data this team works with.  

The primary contacts are AI Lead Engineer and Project Manager.

## Stakeholder requirements

 Booking volumes (predicted vs reality)

- A line chart measuring the difference in booking volumes over time.
- A bar chart t measuring the difference in booking volumes over different markets.
- A bar chart t measuring the difference in booking volumes over flight types.

Booking prices (predicted vs reality)

- A line chart measuring the difference in booking prices over time.
- A line chart measuring the difference in booking prices over different markets.
- A line chart measuring the difference in booking prices over flight types.

## Success criteria

**Specific**: BI insights must clearly identify the specific characteristics of booking predictions, including how often does overbooking happening.

**Measurable**: Predictions should be evaluated using measurable metrics, including volume and prices.

**Action-oriented**: These outcomes must quantify the number of overbooking under different circumstances to provide the AI team with insights into prediction validation.

**Relevant**: All metrics must support the primary question:  how often does overbooking happening?

**Time-bound**: Analyze data that spans at least two years to understand how bookings estimations change over time.

## User journeys

The team’s ultimate goal is to have accurate booking volume and price predictions to eliminate overbooking and streamline the user experience.

## Assumptions

Because the market target is focused on b2b we can assume that the needed booking volumes are almost independent from booking prices.

## Compliance and privacy

The datasets are fictionalized versions of the actual data this team works with. Because of this,
the data is already anonymized and approved.

## Accessibility

The dashboards should offer table alternatives.

## Roll-out plan

The stakeholders have requested a completed BI tool in six weeks.