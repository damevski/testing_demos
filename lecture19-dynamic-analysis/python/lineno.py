import inspect

def record_line_number():
    """Function to record and print the current line number."""
    # Get the current frame, then get its line number
    cf = inspect.currentframe()
    line_no = cf.f_back.f_lineno
    print(f"Executing at line number: {line_no}")
    return line_no 

# Example usage:
record_line_number()  # This line's number will be recorded

def some_function():
    record_line_number()  # This line's number inside the function will be recorded

some_function()  # Call the function to demonstrate line recording within a function

record_line_number()  # Final call to record line number at the end

