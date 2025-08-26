# Set the working directory
setwd("C:/Users/IT24103690/Desktop/IT24103690")

# Importing the dataset (assuming CSV or tabular data with commas as separators)
Delivery_Times <- read.table("Exercise - Lab 05.txt", header = TRUE, sep = ",")

# Check the column names to ensure correct column reference
colnames(Delivery_Times)



# Create breaks for the histogram (9 class intervals from 20 to 70)
breaks <- seq(20, 70, by = (70 - 20) / 9)

# Plot the histogram
hist(Delivery_Times$`Delivery_Time_.minutes`, 
     breaks = breaks, 
     right = TRUE, 
     col = "skyblue", 
     main = "Histogram of Delivery Times", 
     xlab = "Delivery Time (minutes)", 
     ylab = "Frequency")


class(Delivery_Times$`Delivery_Time_.minutes.`)
# Create a frequency table for the data
freq_table <- hist(Delivery_Times$`Delivery_Time_.minutes.`, 
                   breaks = breaks, 
                   right = TRUE, 
                   plot = FALSE)

# Calculate cumulative frequency
cum_freq <- cumsum(freq_table$counts)

# Plot the cumulative frequency polygon (ogive)
plot(freq_table$mids, cum_freq, type = "o", col = "blue", 
     main = "Cumulative Frequency Polygon (Ogive)", 
     xlab = "Delivery Time (minutes)", 
     ylab = "Cumulative Frequency", 
     pch = 16, lwd = 2)



