<?php

namespace BibliothequeBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * RatingLivre
 *
 * @ORM\Table(name="rating_livre")
 * @ORM\Entity
 */
class RatingLivre
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var float
     *
     * @ORM\Column(name="note", type="float", precision=10, scale=0, nullable=false)
     */
    private $note;


    /**
     * @ORM\ManyToOne(targetEntity="AppBundle\Entity\User")
     * @ORM\JoinColumn(name="locataire", referencedColumnName="id")
     */
    private $Locataire;

    /**
     * @ORM\ManyToOne(targetEntity="Livre")
     * @ORM\JoinColumn(name="livre", referencedColumnName="id")
     */
    private $Livre;



    /**
     * Get id
     *
     * @return integer
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set note
     *
     * @param float $note
     *
     * @return RatingLivre
     */
    public function setNote($note)
    {
        $this->note = $note;

        return $this;
    }

    /**
     * Get note
     *
     * @return float
     */
    public function getNote()
    {
        return $this->note;
    }

    /**
     * Set locataire
     *
     * @param \AppBundle\Entity\User $locataire
     *
     * @return RatingLivre
     */
    public function setLocataire(\AppBundle\Entity\User $locataire = null)
    {
        $this->Locataire = $locataire;

        return $this;
    }

    /**
     * Get locataire
     *
     * @return \AppBundle\Entity\User
     */
    public function getLocataire()
    {
        return $this->Locataire;
    }

    /**
     * Set livre
     *
     * @param \BibliothequeBundle\Entity\Livre $livre
     *
     * @return RatingLivre
     */
    public function setLivre(\BibliothequeBundle\Entity\Livre $livre = null)
    {
        $this->Livre = $livre;

        return $this;
    }

    /**
     * Get livre
     *
     * @return \BibliothequeBundle\Entity\Livre
     */
    public function getLivre()
    {
        return $this->Livre;
    }
}
