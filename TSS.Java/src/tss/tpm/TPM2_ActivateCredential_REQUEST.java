package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This command enables the association of a credential with an object in a way that
 *  ensures that the TPM has validated the parameters of the credentialed object.
 */
public class TPM2_ActivateCredential_REQUEST extends TpmStructure
{
    /** Handle of the object associated with certificate in credentialBlob
     *  Auth Index: 1
     *  Auth Role: ADMIN
     */
    public TPM_HANDLE activateHandle;
    
    /** Loaded key used to decrypt the TPMS_SENSITIVE in credentialBlob
     *  Auth Index: 2
     *  Auth Role: USER
     */
    public TPM_HANDLE keyHandle;
    
    /** The credential  */
    public TPMS_ID_OBJECT credentialBlob;
    
    /** KeyHandle algorithm-dependent encrypted seed that protects credentialBlob  */
    public byte[] secret;
    
    public TPM2_ActivateCredential_REQUEST()
    {
        activateHandle = new TPM_HANDLE();
        keyHandle = new TPM_HANDLE();
    }
    
    /** @param _activateHandle Handle of the object associated with certificate in credentialBlob
     *         Auth Index: 1
     *         Auth Role: ADMIN
     *  @param _keyHandle Loaded key used to decrypt the TPMS_SENSITIVE in credentialBlob
     *         Auth Index: 2
     *         Auth Role: USER
     *  @param _credentialBlob The credential
     *  @param _secret KeyHandle algorithm-dependent encrypted seed that protects credentialBlob
     */
    public TPM2_ActivateCredential_REQUEST(TPM_HANDLE _activateHandle, TPM_HANDLE _keyHandle, TPMS_ID_OBJECT _credentialBlob, byte[] _secret)
    {
        activateHandle = _activateHandle;
        keyHandle = _keyHandle;
        credentialBlob = _credentialBlob;
        secret = _secret;
    }
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        buf.writeShort(credentialBlob != null ? credentialBlob.toTpm().length : 0);
        if (credentialBlob != null)
            credentialBlob.toTpm(buf);
        buf.writeSizedByteBuf(secret);
    }
    
    @Override
    public void initFromTpm(InByteBuf buf)
    {
        int _credentialBlobSize = buf.readShort() & 0xFFFF;
        buf.structSize.push(buf.new SizedStructInfo(buf.curPos(), _credentialBlobSize));
        credentialBlob = TPMS_ID_OBJECT.fromTpm(buf);
        buf.structSize.pop();
        int _secretSize = buf.readShort() & 0xFFFF;
        secret = new byte[_secretSize];
        buf.readArrayOfInts(secret, 1, _secretSize);
    }
    
    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.buffer();
    }
    
    public static TPM2_ActivateCredential_REQUEST fromBytes (byte[] byteBuf) 
    {
        TPM2_ActivateCredential_REQUEST ret = new TPM2_ActivateCredential_REQUEST();
        InByteBuf buf = new InByteBuf(byteBuf);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static TPM2_ActivateCredential_REQUEST fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    public static TPM2_ActivateCredential_REQUEST fromTpm (InByteBuf buf) 
    {
        TPM2_ActivateCredential_REQUEST ret = new TPM2_ActivateCredential_REQUEST();
        ret.initFromTpm(buf);
        return ret;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2_ActivateCredential_REQUEST");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "TPM_HANDLE", "activateHandle", activateHandle);
        _p.add(d, "TPM_HANDLE", "keyHandle", keyHandle);
        _p.add(d, "TPMS_ID_OBJECT", "credentialBlob", credentialBlob);
        _p.add(d, "byte", "secret", secret);
    }
}

//<<<
