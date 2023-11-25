const mongoose = require('mongoose')


const userSchema = mongoose.Schema({

    username: {
        type: String,
        required: true,
        unique: true
    },
    password: {
        type: String,
        required: true
    },
    email: {
        type: String,
        required: true,
        trim: true,
        validate(value) {
          if (!value.match(/^[^@ ]+@[^@ ]+\.[^@ .]{2,}$/)) {
            throw new Error('Email is not valid.');
          }
        },
        unique: true
    },
      
    firstName: {
        type: String,
        required: [true, "Please enter your first name!"],
        trim: true
    },
    lastName: {
        type: String,
        required: [true, "Please enter your last name!"],
        trim: true
    },
    
    
    
    sexe: {
        type: String,
        required: [true, "Please enter your sexe!"]
        
    },
    datOfBirth: {
        type: String,
      //  required: [true, "Please enter your date of birth!"]
       
    },
    adress: {
        type: String,
        required: [true, "Please enter your adress!"]
        
    },
    phoneNumber: {
        type: String,
        required: [true, "Please enter your phone number!"]
        
    },

    status: {
        type: String,
        required: [true, "Please enter your acreditation Status !"]
        
    },
    
    image: {
        type: String ,
        default: "https://res.cloudinary.com/devatchannel/image/upload/v1602752402/avatar/avatar_cugq40.png"   
    },




    



})

module.exports = mongoose.model('user', userSchema)