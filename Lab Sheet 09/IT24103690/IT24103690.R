setwd("C:\\Users\\Administrator\\Desktop\\IT24103690")


# Set seed for reproducibility (optional)
set.seed(123)

# Generate random sample of 25 baking times
baking_time <- rnorm(n = 25, mean = 45, sd = 2)

# View the sample
baking_time

# Perform one-sample t-test (one-tailed)
t.test(baking_time, mu = 46, alternative = "less")


#p-value < 0.05 therefore reject H0