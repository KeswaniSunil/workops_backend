const mongoose=require('mongoose');
const User=mongoose.model('User');

const jwt=require('jsonwebtoken');

module.exports=(req,res,next)=>{
    const {authorization}=req.headers;
    if(!authorization){
        return res.status(401).send({error:"You Must be Logged In."});
    }
    if(authorization.search("Bearer ")===-1){
        return res.status(401).send({error:"You Must be Logged In."});
    }
    const token = authorization.replace('Bearer ','');
    jwt.verify(token,'MY_SECRET_KEY',async (err,payload)=>{
    
        if(err){
            return res.status(401).send({error:"You Must Be Logged In"});
        }
        const {userId} = payload;
        const user=await User.findById(userId);
        req.user=user;
        next();
    });
     
}