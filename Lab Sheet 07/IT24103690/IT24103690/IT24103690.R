setwd("C:\\Users\\IT24103690\\Desktop\\IT24103690")

# Uniform distribution: min = 0, max = 40
punif(25, min = 0, max = 40) - punif(10, min = 0, max = 40)

# Exponential distribution: rate = 1/3
pexp(2, rate = 1/3)

# Normal distribution: mean = 100, sd = 15
1 - pnorm(130, mean = 100, sd = 15)
qnorm(0.95, mean = 100, sd = 15)

